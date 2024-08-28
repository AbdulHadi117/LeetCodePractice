def removeDuplicates(nums):
    # edge case, if the list is empty, return 0
    if len(nums) == 0:
        return 0

    # initialize two pointers, i and j
    # i is used to keep track of the position of the next non-duplicate element
    # j is used to traverse the list
    i = 0
    for j in range(1, len(nums)):
        # if the current element is not the same as the previous element
        # move the pointer i to the next position and copy the current element to that position
        if nums[j] != nums[i]:
            i += 1
            nums[i] = nums[j]

    # the number of non-duplicate elements is i + 1
    return i + 1


# Exmaple Usage
nums = [0, 0, 1, 1, 1, 2, 2, 3, 3, 4]
print(removeDuplicates(nums))
