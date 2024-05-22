const Roadmap = require('../models/roadmapModel');

class RoadmapService {
    static async createRoadmap(data) {
        const roadmap = new Roadmap(data);
        await roadmap.save();
        return roadmap;
    }

    static async getRoadmaps() {
        return Roadmap.find({});
    }

    static async getRoadmapById(id) {
        return Roadmap.findById(id);
    }

    static async updateRoadmap(id, data) {
        return Roadmap.findByIdAndUpdate(id, data, { new: true });
    }

    static async deleteRoadmap(id) {
        await Roadmap.findByIdAndDelete(id);
    }
}

module.exports = RoadmapService;