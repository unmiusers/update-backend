/*
 * Copyright 2023-2024 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.jpa.repository.query;

import java.util.List;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.ParserRuleContext;
import org.springframework.data.domain.Sort;
import org.springframework.lang.Nullable;

/**
 * Implements the {@code EQL} parsing operations of a {@link JpaQueryParserSupport} using the ANTLR-generated
 * {@link EqlParser} and {@link EqlQueryTransformer}.
 *
 * @author Greg Turnquist
 * @since 3.2
 */
class EqlQueryParser extends JpaQueryParserSupport {

	EqlQueryParser(String query) {
		super(query);
	}

	/**
	 * Convenience method to parse a EQL query. Will throw a {@link BadJpqlGrammarException} if the query is invalid.
	 *
	 * @param query
	 * @return a parsed query, ready for postprocessing
	 */
	public static ParserRuleContext parseQuery(String query) {

		EqlLexer lexer = new EqlLexer(CharStreams.fromString(query));
		EqlParser parser = new EqlParser(new CommonTokenStream(lexer));

		configureParser(query, lexer, parser);

		return parser.start();
	}

	/**
	 * Parse the query using {@link #parseQuery(String)}.
	 *
	 * @return a parsed query
	 */
	@Override
	protected ParserRuleContext parse(String query) {
		return parseQuery(query);
	}

	/**
	 * Use the {@link EqlQueryTransformer} to transform the original query into a query with the {@link Sort} applied.
	 *
	 * @param parsedQuery
	 * @param sort can be {@literal null}
	 * @return list of {@link JpaQueryParsingToken}s
	 */
	@Override
	protected List<JpaQueryParsingToken> applySort(ParserRuleContext parsedQuery, Sort sort) {
		return new EqlQueryTransformer(sort).visit(parsedQuery);
	}

	/**
	 * Use the {@link EqlQueryTransformer} to transform the original query into a count query.
	 *
	 * @param parsedQuery
	 * @param countProjection
	 * @return list of {@link JpaQueryParsingToken}s
	 */
	@Override
	protected List<JpaQueryParsingToken> doCreateCountQuery(ParserRuleContext parsedQuery,
			@Nullable String countProjection) {
		return new EqlQueryTransformer(true, countProjection).visit(parsedQuery);
	}

	/**
	 * Run the parsed query through {@link EqlQueryTransformer} to find the primary FROM clause's alias.
	 *
	 * @param parsedQuery
	 * @return can be {@literal null}
	 */
	@Override
	protected String doFindAlias(ParserRuleContext parsedQuery) {

		EqlQueryTransformer transformVisitor = new EqlQueryTransformer();
		transformVisitor.visit(parsedQuery);
		return transformVisitor.getAlias();
	}

	/**
	 * Use {@link EqlQueryTransformer} to find the projection of the query.
	 *
	 * @param parsedQuery
	 * @return
	 */
	@Override
	protected List<JpaQueryParsingToken> doFindProjection(ParserRuleContext parsedQuery) {

		EqlQueryTransformer transformVisitor = new EqlQueryTransformer();
		transformVisitor.visit(parsedQuery);
		return transformVisitor.getProjection();
	}

	/**
	 * Use {@link EqlQueryTransformer} to detect if the query uses a {@code new com.example.Dto()} DTO constructor in the
	 * primary select clause.
	 *
	 * @param parsedQuery
	 * @return Guaranteed to be {@literal true} or {@literal false}.
	 */
	@Override
	protected boolean doCheckForConstructor(ParserRuleContext parsedQuery) {

		EqlQueryTransformer transformVisitor = new EqlQueryTransformer();
		transformVisitor.visit(parsedQuery);
		return transformVisitor.hasConstructorExpression();
	}
}
