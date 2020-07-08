package sample;

import lombok.experimental.UtilityClass;
import lombok.extern.slf4j.Slf4j;

/**
 * Trivial class to print domain objects to the console in a somewhat readable format.
 *
 * @author Jens Schauder
 */
@UtilityClass
@Slf4j
public class Output {


	public static void list(Iterable<?> categories, String title) {

		StringBuilder message = new StringBuilder(String.format("==== %s ====\n", title));

		categories.forEach(category -> message.append(category.toString().replace(", ", ",\n\t")));

		log.info(message.toString());
	}
}
