package dev.tehbrian.tehlib.configurate;

public interface DataConfig<W extends ConfigurateWrapper<?>, D> extends Config<W> {

	/**
	 * Gets the data.
	 *
	 * @return the data
	 */
	D data();

}
