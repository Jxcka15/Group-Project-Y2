ALL SQL QUERIES


#All countries in the world organised by largest population.

SELECT name, population
FROM country
ORDER BY population DESC;

#All the countries in a continent organised by largest population to smallest.

SELECT Name, Population
FROM country
WHERE Continent = 'Insert continent here'
ORDER BY Population DESC;

#All the countries in a region organised by largest population to smallest.

SELECT Name, Population
FROM country
WHERE Region = 'your_region_name'
ORDER BY Population DESC;

#The top N populated countries in the world where N is provided by the user.

SELECT Name, Population
FROM country
ORDER BY Population DESC
LIMIT N;

#The top N populated countries in a continent where N is provided by the user.

SELECT Name, Population
FROM country
WHERE Continent = 'your_continent_name'
ORDER BY Population DESC
LIMIT N;

#The top N populated countries in a region where N is provided by the user.

SELECT Name, Population
FROM country
WHERE Region = 'your_region_name'
ORDER BY Population DESC
LIMIT N;

#All the cities in the world organised by largest population to smallest.

SELECT Name, Population
FROM city
ORDER BY Population DESC;

#All the cities in a continent organised by largest population to smallest.

SELECT city.Name, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Continent = 'your_continent_name'
ORDER BY city.Population DESC;

#All the cities in a region organised by largest population to smallest.

SELECT city.Name, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Region = 'your_region_name'
ORDER BY city.Population DESC;

#All the cities in a country organised by largest population to smallest.

SELECT Name, Population
FROM city
WHERE CountryCode = 'your_country_code'
ORDER BY Population DESC;

#All the cities in a district organised by largest population to smallest.

SELECT Name, Population
FROM city
WHERE District = 'your_district_name'
ORDER BY Population DESC;

#The top N populated cities in the world where N is provided by the user.

SELECT Name, Population
FROM city
ORDER BY Population DESC
LIMIT N;

#The top N populated cities in a continent where N is provided by the user.

SELECT city.Name, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Continent = 'your_continent_name'
ORDER BY city.Population DESC
LIMIT N;

#The top N populated cities in a region where N is provided by the user.

SELECT city.Name, city.Population
FROM city
JOIN country ON city.CountryCode = country.Code
WHERE country.Region = 'your_region_name'
ORDER BY city.Population DESC
LIMIT N;

#The top N populated cities in a country where N is provided by the user.

SELECT *
FROM city
WHERE countrycode='<country>'
ORDER BY population DESC LIMIT <N>;

#The top N populated cities in a district where N is provided by the user.

SELECT *
FROM city
WHERE district='<district>'
ORDER BY population DESC LIMIT <N>;

#All the capital cities in the world organised by largest population to smallest.

SELECT *
FROM city
JOIN country ON city.id=country.capital
WHERE country.continent='<continent>'
ORDER BY population DESC;

#All the capital cities in a continent organised by largest population to smallest.

SELECT *
FROM city
JOIN country ON city.id=country.capital
WHERE country.continent='<continent>'
ORDER BY population DESC;

#All the capital cities in a region organised by largest to smallest.

SELECT *
FROM city
JOIN country ON city.id=country.capital
WHERE country.region='<region>'
ORDER BY population DESC;

#The top N populated capital cities in the world where N is provided by the user.

SELECT *
FROM city
JOIN country ON city.id=country.capital
WHERE country.continent='<continent>'
ORDER BY population DESC LIMIT <N>;

#The top N populated capital cities in a continent where N is provided by the user.

SELECT *
FROM city
JOIN country ON city.id=country.capital
WHERE country.continent='<continent>'
ORDER BY population DESC LIMIT <N>;

#The top N populated capital cities in a region where N is provided by the user.

SELECT *
FROM city
JOIN country ON city.id=country.capital
WHERE country.region='<region>'
ORDER BY population DESC LIMIT <N>;

#The population of people, people living in cities, and people not living in cities in each continent.

SELECT continent, SUM(population) AS total_population, SUM(IF(isurban=1, population, 0)) AS urban_population, SUM(IF(isurban=0, population, 0)) AS rural_population
FROM country JOIN city ON country.code=city.countrycode
GROUP BY continent;

#The population of people, people living in cities, and people not living in cities in each region.

SELECT region, SUM(population) AS total_population, SUM(IF(isurban=1, population, 0)) AS urban_population, SUM(IF(isurban=0, population, 0)) AS rural_population
FROM country JOIN city ON country.code=city.countrycode
GROUP BY region;

#The population of people, people living in cities, and people not living in cities in each country.

SELECT country.name, SUM(country.population) AS total_population, SUM(IF(city.isurban=1, city.population, 0)) AS urban_population, SUM(IF(city.isurban=0, city.population, 0)) AS rural_population
FROM country
JOIN city ON country.code=city.countrycode
GROUP BY country.name;

#The population of the world.

SELECT SUM(population) AS total_population
FROM country;

#The population of a continent.

SELECT SUM(population) AS total_population
FROM country
WHERE continent='<continent>';

#The population of a region.

SELECT SUM(population) AS total_population
FROM country
WHERE region='<region>';

#The population of a country.

SELECT population
FROM country
WHERE name='<country>';

#The population of a district.

SELECT population
FROM city
WHERE name='<city>' AND district='<district>';

#The population of a city.

SELECT population
FROM city
WHERE name='<city>';

#Number of people who speak Chinese

SELECT language, SUM(population) AS total_population,
ROUND(SUM(population)/(SELECT SUM(population) FROM country)*100,2) AS percentage_of_world_population
FROM countrylanguage
WHERE language='Chinese'
GROUP BY language;

#Number of people who speak English

SELECT language, SUM(population) AS total_population,
ROUND(SUM(population)/(SELECT SUM(population) FROM country)*100,2) AS percentage_of_world_population
FROM countrylanguage
WHERE language='English'
GROUP BY language;

#Number of people who speak Hindi

SELECT language, SUM(population) AS total_population,
ROUND(SUM(population)/(SELECT SUM(population) FROM country)*100,2) AS percentage_of_world_population
FROM countrylanguage
WHERE language='Hindi'
GROUP BY language;

#Number of people who speak Spanish

SELECT language, SUM(population) AS total_population,
ROUND(SUM(population)/(SELECT SUM(population) FROM country)*100,2) AS percentage_of_world_population
FROM countrylanguage
WHERE language='Spanish'
GROUP BY language;

#Number of people who speak Arabic

SELECT language, SUM(population) AS total_population,
ROUND(SUM(population)/(SELECT SUM(population) FROM country)*100,2) AS percentage_of_world_population
FROM countrylanguage
WHERE language='Arabic'
GROUP BY language;




















