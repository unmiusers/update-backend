const Milestone = require('../models/milestoneModel');

class MilestoneService {
    static async createMilestone(data) {
        const milestone = new Milestone(data);
        await milestone.save();
        return milestone;
    }

    static async getMilestones() {
        return Milestone.find({});
    }

    static async getMilestoneById(id) {
        return Milestone.findById(id);
    }

    static async updateMilestone(id, data) {
        return Milestone.findByIdAndUpdate(id, data, { new: true });
    }

    static async deleteMilestone(id) {
        await Milestone.findByIdAndDelete(id);
    }
}

module.exports = MilestoneService;