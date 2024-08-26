def isValid(s):
    # Create a mapping of opening to closing parentheses
    mapping = {"(": ")", "[": "]", "{": "}"}
    # Initialize a stack to keep track of the parentheses
    stack = []
    # Iterate over each character in the string
    for char in s:
        # If the character is an opening parenthesis, push its corresponding closing parenthesis onto the stack
        if char in mapping:
            stack.append(mapping[char])
        # If the character is a closing parenthesis, check if the stack is empty or if the top of the stack doesn't match the current character
        else:
            if not stack or char != stack.pop():
                # If the stack is empty or the top of the stack doesn't match the current character, return False
                return False
    # If the stack is empty after iterating over the entire string, return True
    return len(stack) == 0


# Example Usage
s = "()[]{}"
print(isValid(s))
