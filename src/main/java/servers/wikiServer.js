const Wiki = require('../models/wikiModel');

class WikiService {
    static async createWikiPage(data) {
        const page = new Wiki(data);
        await page.save();
        return page;
    }

    static async getWikiPages() {
        return Wiki.find({});
    }

    static async getWikiPageById(id) {
        return Wiki.findById(id);
    }

    static async updateWikiPage(id, data) {
        return Wiki.findByIdAndUpdate(id, data, { new: true });
    }

    static async deleteWikiPage(id) {
        await Wiki.findByIdAndDelete(id);
    }
}

module.exports = WikiService;