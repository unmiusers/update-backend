// 通知相关控制器
const NotificationService = require("../services/notificationService");

// 示例控制器方法
async function sendNotification(req, res, next) {
    try {
        const { recipient, message } = req.body;
        const sentNotification = await NotificationService.sendNotification(recipient, message);
        res.json(sentNotification);
    } catch (error) {
        next(error);
    }
}

module.exports = {
    sendNotification
};