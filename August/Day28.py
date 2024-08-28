def findWords(words):
    # edge case, if the list is empty, return an empty list
    if len(words) == 0:
        return []

    # create a set of the first row letters
    first_row = {"q", "w", "e", "r", "t", "y", "u", "i", "o", "p"}

    # create a set of the second row letters
    second_row = {"a", "s", "d", "f", "g", "h", "j", "k", "l"}

    # create a set of the third row letters
    third_row = {"z", "x", "c", "v", "b", "n", "m"}

    # create an empty list to store the result
    result = []

    # iterate over each word in the list
    for word in words:
        # create a set of the letters in the word
        letters = set(word.lower())

        # check if the letters in the word are in the first row
        if letters.issubset(first_row):
            result.append(word)

        # check if the letters in the word are in the second row
        elif letters.issubset(second_row):
            result.append(word)

        # check if the letters in the word are in the third row
        elif letters.issubset(third_row):
            result.append(word)

    return result
