-- Originally completed by Chris on 2/28/15
-- What is the sum of the digits of 100!

factorial n acc
	| n == 1 = acc
	| otherwise = factorial (n - 1) (acc * n)

countDigits n acc
	| n == 0 = acc
	| otherwise = countDigits (div n 10) (acc + (mod n 10))

main = do putStrLn $ show $ countDigits (factorial 100 1) 0
