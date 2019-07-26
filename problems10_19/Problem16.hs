doSum n acc
	| n == 0 = acc
	| otherwise = doSum (div n 10) (acc + (mod n 10))

main = do 
	putStrLn $ show (doSum (2^1000) 0)
