package Aula12;

public abstract class PluginManagerEx3 {
	public static IPluginEx3 load(String name) throws Exception {
		Class<?> c = Class.forName(name);
		return (IPluginEx3) c.newInstance(); }
}
