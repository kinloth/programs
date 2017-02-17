#include <stdio.h>
#include <math.h>
//#include "geodist.h"

#define RAD(a) ((a * M_PI) / 180.0)


/*
 * Codigo para calcular a distancia geografica entre dois pontos dadas
 * as coordenadas de latitude e longitude de cada um deles. O calculo
 * ignora variacoes de elevacao, e assume que a superficie da Terra eh
 * esferica.
 */

typedef struct {
 
	double x;
	double y;
	double z;

} Vector;

typedef struct {

	double latitude;
	double longitude;

} Coordinate;

Coordinate coordinate(double latitude, double longitude){
	
	Coordinate c;

	c.latitude = latitude;
	c.longitude = longitude;

	return c;
}

Vector vector(Coordinate c){

	Vector v;

	double lat = RAD(c.latitude);
	double lon = RAD(c.longitude);

	v.x = cos(lat) * sin(lon);
	v.y = sin(lat);
	v.z = cos(lat) * cos(lon);

	return v;
}

double dot(Vector v1, Vector v2){

	return 	v1.x * v2.x +
		v1.y * v2.y + 
		v1.z * v2.z
	;
}

int distance(Coordinate c1, Coordinate c2, double radius){

	Vector p1 = vector(c1);
	Vector p2 = vector(c2);

	double angle = acos(dot(p1, p2));
	double distance = angle * radius;

	return lrint(distance);
}

