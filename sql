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









