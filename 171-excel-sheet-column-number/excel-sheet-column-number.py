class Solution(object):
    def titleToNumber(self, columnTitle):
        total = 0
        
        for char in columnTitle:
            value = ord(char) - ord('A') + 1
            total = total * 26 + value
            
        return total