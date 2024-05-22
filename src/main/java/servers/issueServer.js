const Issue = require('../models/issueModel');

class IssueService {
    static async createIssue(data) {
        const issue = new Issue(data);
        await issue.save();
        return issue;
    }

    static async getIssues() {
        return Issue.find({});
    }

    static async getIssueById(id) {
        return Issue.findById(id);
    }

    static async updateIssue(id, data) {
        return Issue.findByIdAndUpdate(id, data, { new: true });
    }

    static async deleteIssue(id) {
        await Issue.findByIdAndDelete(id);
    }
}

module.exports = IssueService;