-- Find the fraction for d < 1000 for which 1/d has
-- the longest non-repeating decimal fractional part

-- Originally completed by Chris on Sun, 28 Dec 2014, 10:40

findPeriod :: Int -> Int -> [Int] -> Int
findPeriod n rem lst 
	| elem rem lst = length lst
	| otherwise = let nextRem = (mod (rem * 10) n)
			  nextLst = rem:lst
		      in findPeriod n nextRem nextLst

pickBigger a b
	| head a > head b = a
	| otherwise = b

main = let set = [1..1000]
	   results = map (\x -> (findPeriod x 1 []):[x]) set
	   result = foldr (\x y -> pickBigger x y) [0, -1] results
       in do putStrLn $ show $ result
