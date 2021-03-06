#include <stdio.h>
#include <math.h>

#define RAD(a) ((a * M_PI) / 180.0)

//MARCELO GAIOSO WERNECK
//NUSP = 8061963

typedef struct {
        

	double x;
	double y;
	double z;

} Vector;

typedef struct {

	double latitude;
	double longitude;

} Coordinate;

Coordinate coordinate(double latitude, double longitude);
Vector vector(Coordinate c);
double dot(Vector v1, Vector v2);
int distance(Coordinate c1, Coordinate c2, double radius);
