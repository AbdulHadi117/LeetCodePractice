def count_citizens_over_60(details_of_citizens):
    count = 0
    for detail in details_of_citizens:
        if int(detail[11:13]) > 60:
            count += 1
    return count

# Example usage:
details_of_citizens = [
    "7868190130M7522",
    "5303914400F9211",
    "9273338290F4010"
]

count = count_citizens_over_60(details_of_citizens)
print(f"There are {count} people who are over 60 years old")