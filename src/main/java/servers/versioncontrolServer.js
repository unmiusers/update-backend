const VersionControl = require('../models/versionControlModel');

class VersionControlService {
    static async getVersionControlInfo() {
        return VersionControl.find({});
    }

    static async getCommitById(id) {
        return VersionControl.findById(id);
    }

    static async getFileContent(id) {
        return VersionControl.findById(id);
    }
}

module.exports = VersionControlService;