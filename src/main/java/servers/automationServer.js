const Automation = require('../models/automationModel');

class AutomationService {
    static async createAutomation(data) {
        const automation = new Automation(data);
        await automation.save();
        return automation;
    }

    static async getAutomations() {
        return Automation.find({});
    }

    static async getAutomationById(id) {
        return Automation.findById(id);
    }

    static async updateAutomation(id, data) {
        return Automation.findByIdAndUpdate(id, data, { new: true });
    }

    static async deleteAutomation(id) {
        await Automation.findByIdAndDelete(id);
    }
}

module.exports = AutomationService;