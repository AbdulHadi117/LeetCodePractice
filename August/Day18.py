def nthUglyNumber(n):
    # Initialize a list to store the ugly numbers
    ugly = [1]

    # Initialize indices to track the current position in the list for factors 2, 3, and 5
    i2 = i3 = i5 = 0

    # Loop until the desired length of the list is reached
    while len(ugly) < n:

        # Calculate the next ugly number by multiplying the current number by the respective factors
        v2 = ugly[i2] * 2
        v3 = ugly[i3] * 3
        v5 = ugly[i5] * 5

        # Find the minimum of the three numbers
        v = min(v2, v3, v5)

        # Increment the index corresponding to the factor used
        if v == v2:
            i2 += 1
        if v == v3:
            i3 += 1
        if v == v5:
            i5 += 1

        # Append the calculated ugly number to the list
        ugly.append(v)

    # Return the nth ugly number
    return ugly[n-1]


# Example Usage
print(nthUglyNumber(10))

