import Data.Matrix

getMatVal mazeDimX mazeDimY  i j
	| i == j && isTB && isLR = 2-- corner
	| i == j && (isTB || isLR) = 3 -- side
	| i == j = 4 -- center
	| absdiff == mazeDimX = -1 --above and below connections
	| modres == 1 && (j-i == -1) = 0 --  LR neighbors L side
	| modres == 0 && (j-i == 1) = 0 -- LR neighbors R side
	| absdiff == 1 = -1
	| otherwise = 0 -- not connected
	where isTB = (i <= mazeDimX) || i > ((mazeDimY-1) * mazeDimX) 
	      modres =  mod i mazeDimX
	      differentRows = (div (i - 1) mazeDimX) == (div (j - 1) mazeDimX)
	      isLR = modres <= 1
	      absdiff = abs (i - j)
func szx szy =
	let sz = szx * szy
	in  matrix sz sz $ \(i,j) -> getMatVal szx szy i j

main = let leng = 2
	   width = 3
	   fsize = leng * width
           mat = func width leng
	   smaller = submatrix 2 fsize 2 fsize mat
	   smallersz = fsize - 1
       in do putStrLn $ show $ smaller
--
-- 1  2  3  
-- 4  5  6
-- 7  8  9
-- 10 11 12
