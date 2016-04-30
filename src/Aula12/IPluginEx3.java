package Aula12;

import java.io.File;

import Aula5.Pessoa;

public interface IPluginEx3 {
	public void read(String f);
	public void write(Pessoa[] array, String f);
	public void save(File f);
}