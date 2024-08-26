def passThePillow(number,time):
    # Initialize the current position and time
    currPosition = 1
    currTime = 0
    # Initialize the direction of the pillow
    direction = 1

    # Simulate the action of passing the pillow
    while currTime < time:
        # Move the pillow to the next person
        if direction == 1:
            currPosition +=1
        # Move the pillow to the previous person
        else:
            currPosition -=1
        # Change the direction of the pillow when it reaches the end
        if currPosition == number:
            direction = -1
        # Change the direction of the pillow when it reaches the start
        elif currPosition == 1:
            direction = 1
        # Increment the time
        currTime +=1

    # Return the position of the pillow
    return currPosition

# Example
number = 3
time = 2
print(passThePillow(number,time))
