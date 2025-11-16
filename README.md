# train-organizer

Inputs: when entering the freight of a reefer or normal train car it can be any String. For the weight and temperature, they both must be int

Conditions on Train: Two train cars can only be next to each other if the have the same freight OR the same weight. If there are two reefers next to each other they can connect on the other condition OR if the difference between their temperature is at most 5. If none of these conditions are met when adding or removing, the car will not be added/removed and an error message will be displayed in the console.
