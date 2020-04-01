
import countries.*;

var countries = new Countries().getAll();

//1.Returns whether there is at least one country with the word _island_ in its name ignoring case.

countries.stream().anyMatch(country -> country.getName().toLowerCase().contains("island"));

//2. Returns the first country name that contains the word _island_ ignoring case.

countries.stream().filter(country -> country.getName().toLowerCase().contains("island")).findFirst().get().getName();

//3. Prints each country name in which the first and the last letters are the same ignoring case.

countries.stream().filter(country -> country.getName().toLowerCase().charAt(0)== country.getName().toLowerCase().charAt(country.getName().length()-1)).map(Country::getName).forEach(System.out::println);

//4. Prints the populations of the first ten least populous countries

countries.stream().mapToLong(Country::getPopulation).sorted().limit(10).forEach(System.out::println);

//5. Prints the names of the first ten least populous countries

countries.stream().sorted(Comparator.comparingLong(Country::getPopulation)).limit(10).map(Country::getName).forEach(System.out::println);

//6.Returns summary statistics about the number of country name translations associated with each country.

//7.Prints the names of countries in the ascending order of the number of timezones.

countries.stream().sorted(Comparator.comparing(country -> country.getTimezones().size())).map(Country::getName).forEach(System.out::println);

//8.Prints the number of timezones for each country in the form _name_`: `_population_, in the ascending order of the number of timezones.

countries.stream().sorted(Comparator.comparing(country -> country.getTimezones().size())).forEach(country ->System.out.println(country.getName()+":"+country.getPopulation()));

//9.Returns the number of countries with no Spanish country name translation (the Spanish language is identified by the language code `es`)

countries.stream().filter(country -> ! country.getTranslations().containsKey("es")).map(Country::getName).forEach(System.out::println);

//10.Prints the names of countries with `null` area.

countries.stream().filter(country -> country.getArea()==null).map(Country::getName).forEach(System.out::println);

//11.Prints all distinct language tags of country name translations sorted in alphabetical order

//12. Returns the average length of country names.

countries.stream().mapToInt(country -> country.getName().length()).sum()/(double)countries.stream().count();

//13. Prints all distinct regions of the countries with `null` area.

countries.stream().filter(country -> country.getArea() == null).map(Country::getRegion).distinct().forEach(System.out::println);

//14. Returns the largest country with non-`null` area.

countries.stream().filter(country -> country.getArea()!=null).max(Comparator.comparing(country -> country.getArea()));

//15. Prints the names of countries with a non-`null` area below 10

countries.stream().filter(country -> country.getArea() != null && country.getArea().compareTo(BigDecimal.TEN) < 0).map(Country::getName).forEach(System.out::println);

//16. Prints all distinct timezones of European and Asian countries.

countries.stream().filter(country -> country.getRegion()==Region.EUROPE || country.getRegion()==Region.ASIA).flatMap(country -> country.getTimezones().stream()).distinct().forEach(System.out::println);
