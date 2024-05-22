const Plugin = require('../models/pluginModel');

class PluginService {
    static async installPlugin(data) {
        const plugin = new Plugin(data);
        await plugin.save();
        return plugin;
    }

    static async getPlugins() {
        return Plugin.find({});
    }

    static async getPluginById(id) {
        return Plugin.findById(id);
    }

    static async updatePlugin(id, data) {
        return Plugin.findByIdAndUpdate(id, data, { new: true });
    }

    static async deletePlugin(id) {
        await Plugin.findByIdAndDelete(id);
    }
}

module.exports = PluginService;