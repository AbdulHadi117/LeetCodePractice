def maxArea(height):
    # initialize max_width to the maximum value in height
    max_width = max(height)

    # initialize variables
    max_area = 0
    leftIndex = 0
    rightIndex = len(height) - 1

    # loop through the height array from left to right
    while leftIndex < rightIndex:

        # calculate the length of the current container
        length = rightIndex - leftIndex

        # calculate the width of the current container
        wdith = min(height[leftIndex], height[rightIndex])

        # calculate the area of the current container
        area = length * wdith

        # update max_area
        max_area = max(area, max_area)

        # if the height at leftIndex is less than the height at rightIndex, increment leftIndex
        if height[leftIndex] < height[rightIndex]:
            leftIndex += 1
        # otherwise, decrement rightIndex
        else:
            rightIndex -= 1

        # if max_area is greater than or equal to max_width * length, there is no need to continue the loop
        if max_area >= max_width * length:
            break

    # return the maximum area
    return max_area


# Example usage
height = [1, 8, 6, 2, 5, 4, 8, 3, 7]
print(maxArea(height))
