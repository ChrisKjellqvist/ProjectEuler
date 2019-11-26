-- log10(9^5 * 7) < 7 Therefore all numbers that can be written as the 5th power of their
-- digits are <= 1 000 000. 
-- Find the sum of the numbers that can be written as the sum of the fifth power of their
-- digits

pow5 x = x * x * x * x * x

pow5sum x =
	let ones = pow5 $ mod x 10
	    tens = pow5 $ mod (div x 10) 10
	    huns = pow5 $ mod (div x 100) 10
	    thou = pow5 $ mod (div x 1000) 10
	    ttho = pow5 $ mod (div x 10000) 10
	    htho = pow5 $ mod (div x 100000) 10
	in x == ones + tens + huns + thou + ttho + htho

main = do putStrLn $ show $ (sum [x | x <- [1..999999], pow5sum x]) - 1
