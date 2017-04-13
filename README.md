# Build Instructions
1. Import into Eclipse or your prefered IDE as an Eclipse project
2. Right click the project file within your IDE and select "Run As - Java Application" or the equivalent in your IDE

# Assumptions
I have assumed that the user will not enter out of bounds coordinates, although if they do the program can still function and will simply give the closest events to that position.

I have also assumed that the user will not look at multiple locations within the same world. To workaround this a loop could be implemented so that the user can keep querying multiple locations in the same world.

Another assumption I've made is that the user will input their coordinates in the exact format: #,# with no spaces between any of the numbers

# Improvements 
## Multiple Events at Locations
Due to the way I've implemented the events you could have events at the same location now without problem. Had I used a two-dimensional array implementation I would make it so that each space in the array contained a linked list of events.
## Larger World Size
Sorting the events and then creating a smaller list of the closest events would be masively inefficient in a larger world due to the amount of possible events. 
To solve this I would probably create zones which themselves contained grids. So you'd simply look within a zone the user location existed and do the same as is already implemented.
