def lemonadeChange(bills):
    # Initialize counters for $5 and $10 bills
    five = ten = 0

    # Iterate through each bill in the list
    for bill in bills:
        # If the bill is $5, increment the $5 counter
        if bill == 5:
            five += 1
        # If the bill is $10, decrement the $5 counter (since we need a $5 to make change)
        # and increment the $10 counter
        elif bill == 10:
            # If we don't have any $5 bills, we can't make change, so return False
            if not five:
                return False
            five -= 1
            ten += 1
        # If the bill is $20, we need to make change using $10 and $5 bills
        else:
            # If we have at least one $10 bill and one $5 bill, use those to make change
            if ten and five:
                ten -= 1
                five -= 1
            # If we don't have a $10 bill, we need three $5 bills to make change
            elif five >= 3:
                five -= 3
            # If we can't make change, return False
            else:
                return False
    # If we made it through the entire list without returning False, return True
    return True

# Test the function with a sample list of bills
bills = [5, 5, 10, 10, 20]
print(lemonadeChange(bills))  # Should print True