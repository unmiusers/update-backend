const AgileProject = require('../models/agileModel');

class AgileService {
    static async createAgileProject(data) {
        const project = new AgileProject(data);
        await project.save();
        return project;
    }

    static async getAgileProjects() {
        return AgileProject.find({});
    }

    static async getAgileProjectById(id) {
        return AgileProject.findById(id);
    }

    static async updateAgileProject(id, data) {
        return AgileProject.findByIdAndUpdate(id, data, { new: true });
    }

    static async deleteAgileProject(id) {
        await AgileProject.findByIdAndDelete(id);
    }
}

module.exports = AgileService;