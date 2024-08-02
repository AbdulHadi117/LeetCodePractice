def count_citizens_over_60(details_of_citizens):
    # Initialize counter
    count = 0
    
    # Iterate through each detail
    for detail in details_of_citizens:
        # Extract and check age
        if int(detail[11:13]) > 60:
            count += 1
    
    # Return count of citizens over 60
    return count

# Example usage:
details_of_citizens = [
    "7868190130M7522",  # Age 75
    "5303914400F9211",  # Age 92
    "9273338290F4010"   # Age 40
]

# Count citizens over 60
count = count_citizens_over_60(details_of_citizens)

# Print result
print(f"There are {count} people who are over 60 years old")
