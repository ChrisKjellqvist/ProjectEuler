find_ways_to_coin remain coins
	| remain == 0 = 1
	| null coins = 1
	| otherwise = foldr (+) 0 numWays
	where currCoin = head coins
	      AmtLeftAfterUsingCoin = map (\x -> remain - (x * currCoin)) [0..(div remain currCoin)]
	      numWays = map (\x -> find_ways_to_coin x (tail coins)) AmtLeftAfterUsingCoin 

main = do putStrLn $ show $ find_ways_to_coin 200 [200, 100, 50, 20, 10, 5, 2]
