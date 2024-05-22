const CalendarEvent = require('../models/calendarModel');

class CalendarService {
    static async createEvent(data) {
        const event = new CalendarEvent(data);
        await event.save();
        return event;
    }

    static async getEvents() {
        return CalendarEvent.find({});
    }

    static async getEventById(id) {
        return CalendarEvent.findById(id);
    }

    static async updateEvent(id, data) {
        return CalendarEvent.findByIdAndUpdate(id, data, { new: true });
    }

    static async deleteEvent(id) {
        await CalendarEvent.findByIdAndDelete(id);
    }
}

module.exports = CalendarService;