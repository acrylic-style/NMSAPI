package xyz.acrylicstyle.craftbukkit.v1_8_R3.help;

import com.google.common.base.Predicate;
import org.bukkit.command.Command;
import org.bukkit.help.HelpTopic;
import org.bukkit.help.HelpTopicFactory;
import xyz.acrylicstyle.craftbukkit.v1_8_R3.CraftServer;
import xyz.acrylicstyle.shared.OBCAPI;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.function.BooleanSupplier;

public class SimpleHelpMap extends OBCAPI {
    public static final Class<?> CLASS = getClassWithoutException("SimpleHelpMap");

    /**
     * Read-only.
     */
    public Map<String, HelpTopic> helpTopics;

    public SimpleHelpMap(Object o) {
        super(o, "SimpleHelpMap");
        sync();
    }

    public SimpleHelpMap(CraftServer server) {
        super("SimpleHelpMap", server.getOBCClass());
        sync();
    }

    @SuppressWarnings("unchecked")
    public void sync() {
        helpTopics = (Map<String, HelpTopic>) getField("helpTopics");
    }

    public synchronized void addTopic(HelpTopic topic) {
        invoke("addTopic", topic);
        sync();
    }

    public synchronized void clear() {
        invoke("clear");
        sync();
    }

    @SuppressWarnings("unchecked")
    public List<String> getIgnoredPlugins() {
        return (List<String>) invoke("getIgnoredPlugins");
    }

    public synchronized void initializeGeneralTopics() {
        invoke("initializeGeneralTopics");
        sync();
    }

    public synchronized void initializeCommands() {
        invoke("initializeCommands");
        sync();
    }

    public void fillPluginIndexes(Map<String, Set<HelpTopic>> pluginIndexes, Collection<? extends Command> commands) {
        invoke("fillPluginIndexes", pluginIndexes, commands);
        sync();
    }

    public String getCommandPluginName(Command command) {
        return (String) invoke("getCommandPluginName");
    }

    public boolean commandInIgnoredPlugin(Command command, Set<String> ignoredPlugins) {
        return (boolean) invoke("commandInIgnoredPlugin", command, ignoredPlugins);
    }

    public void registerHelpTopicFactory(Class<?> commandClass, HelpTopicFactory<Command> factory) {
        invoke("registerHelpTopicFactory", commandClass, factory);
        sync();
    }

    public static class IsCommandTopicPredicate implements Predicate<HelpTopic> {
        public boolean apply(HelpTopic topic) {
            return (topic.getName().charAt(0) == '/');
        }
    }
}
