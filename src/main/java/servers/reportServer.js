const Report = require('../models/reportModel');

class ReportService {
    static async createReport(data) {
        const report = new Report(data);
        await report.save();
        return report;
    }

    static async getReports() {
        return Report.find({});
    }

    static async getReportById(id) {
        return Report.findById(id);
    }

    static async updateReport(id, data) {
        return Report.findByIdAndUpdate(id, data, { new: true });
    }

    static async deleteReport(id) {
        await Report.findByIdAndDelete(id);
    }
}

module.exports = ReportService;