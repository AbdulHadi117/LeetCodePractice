def findComplement(num):

    # Convert the number to binary
    binary = ''
    while num > 0:
        binary = str(num % 2) + binary
        num = num // 2

    # Flip the bits
    flipped = ''
    for num in binary:
        if num == '1':
            flipped += '0'
        else:
            flipped += '1'
    
    # Return in Base 10
    return int(flipped, 2)

# Example Usage
num = 5
print(findComplement(num))
