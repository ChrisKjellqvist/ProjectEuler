-- Find the first fibonacci number with 1000 digits
-- Originally completed by Chris on Sat, 15 Nov 2014, 02:03


import Math.NumberTheory.Logarithms

fib :: Integer -> Integer -> Integer -> Integer
fib a b c
	| ((integerLog10 a) >= 999) = c -- 10 is 2 digits and log_10(10) = 1, so look for log_10(x) = 999
	| otherwise = fib b (a+b) (succ c)

main = do putStrLn $ show $ (fib 1 1 1)
