const User = require('../models/userModel');

class UserService {
    static async createUser(data) {
        const user = new User(data);
        await user.save();
        return user;
    }

    static async getUsers() {
        return User.find({});
    }

    static async getUserById(id) {
        return User.findById(id);
    }

    static async updateUser(id, data) {
        return User.findByIdAndUpdate(id, data, { new: true });
    }

    static async deleteUser(id) {
        await User.findByIdAndDelete(id);
    }
}

module.exports = UserService;