const Notification = require('../models/notificationModel');

class NotificationService {
    static async createNotification(data) {
        const notification = new Notification(data);
        await notification.save();
        return notification;
    }

    static async getNotifications() {
        return Notification.find({});
    }

    static async getNotificationById(id) {
        return Notification.findById(id);
    }

    static async updateNotification(id, data) {
        return Notification.findByIdAndUpdate(id, data, { new: true });
    }

    static async deleteNotification(id) {
        await Notification.findByIdAndDelete(id);
    }
}

module.exports = NotificationService;