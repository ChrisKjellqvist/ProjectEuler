-- limit for number is 2540160 because 7 digit numbers can be represented
-- possibly by the sum of their digits' factorials, whereas no 8 digit
-- numbers can, because 99999999's digit factorial sum is only 7 digits.
-- Seeing what the answer ends up being definitely indicates that the
-- limit could be much lower, but this computes fast enough so I'm not
-- willing to improve this bound.

-- Find the sum of all numbers whose digits' factorials sum to that number
-- 1! + 4! + 5! = 145

factorial n
	| n == 0 = 1
	| n == 1 = 1
	| n == 2 = 2
	| n == 3 = 6
	| n == 4 = 24
	| n == 5 = 120
	| n == 6 = 720
	| n == 7 = 720 * 7
	| n == 8 = 720 * 7 * 8
	| n == 9 = 720 * 7 * 8 * 9
	| otherwise = error ("too long!" ++ (show n))

factorialDigitSum orig a sum
	| a == 0 = orig == sum
	| sum > orig = False
	| otherwise = factorialDigitSum orig (div a 10) (sum + (factorial (mod a 10)))

main = do putStrLn $ show $ sum [x | x <- [3..2540160], (factorialDigitSum x x 0)]
