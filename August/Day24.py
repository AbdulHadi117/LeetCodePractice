def isMatch(text, pattern):
    dp = [[False for j in range(len(pattern)+1)] for i in range(len(text)+1)]
    dp[len(text)][len(pattern)] = True
    # iterate over the text and pattern from the end to the beginning
    for i in range(len(text),-1,-1):
        for j in range(len(pattern)-1,-1,-1):
            # check if the current character in the text matches the current character in the pattern
            match = (i < len(text) and (pattern[j] == text[i] or pattern[j] == '.'))
            # if the current character in the pattern is '*', check two cases
            if (j+1 < len(pattern) and pattern[j+1] == '*'):
                # case 1: the '*' matches zero of the preceding element
                dp[i][j] = dp[i][j+2] or (match and dp[i+1][j])
            else:
                # case 2: the '*' matches one or more of the preceding element
                dp[i][j] = match and dp[i+1][j+1]
    return dp[0][0]

# Example Usage
text = "aa", pattern = "a*"
print(isMatch(text,pattern))

