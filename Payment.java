// Programming Assignment #2 -- RentalDue
// CSCI-2251 Spring 2019, Section 101, Intermediate Computer Programming
// By: Dr. Chu J. Jong, 02/18/2019
//
// ============================================================================
// This assignment implements interface, and applies object inheritance and
// polymorphism to the class hierarchy.
// There are three objects, RentalProperty is the super class of to subclasses
// SingleFamilyRental and ApartmentRental. A payment interface is implemented
// by the two subclasses. Polymorphism is used to increase the monthly rental
// by certain percentage subject to the property types. Finally list all monthly
// rentals on the console in a sorted order.
// ============================================================================= 
//
// This is the interface class implemented by all rental classes
//

interface Payment
{
	double outputCurrentRent();
}