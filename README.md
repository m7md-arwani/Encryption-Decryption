# Encryption-Decryption

## Description

This project Encrypt and Decrypt given text through arguments passed via the main method.
Two main algorithms were used that are Unicode, and Shift. For clarity have a look at this demonstration video.
 


## Usage

A [video](https://stepik.org/media/attachments/lesson/209884/demonstration.mp4) for clarifying the process of inserting the inputs.

### Explaining the arguments

#### -mode
this argument is responsible for specifying the operation. It's either "dec" (without the quotes) for Decryption or "enc" for Encryption.
If not written, the program will assume Encryption.

#### -data & -in

Both of these are responsible for input. However, -data will take the input from the text written directly after it. Whereas -in takes the input from a file. It is enough to write the file name. Note that the file should be in the same file as the program. -data is preferred by the program. Thus, when both -data & -in ara available, the program chooses -data.
Note that both options take their text between quotes.

#### -key

The encryption key represents how many times the characters of the text will get shifted. If not inserted, the program assumes a value of 0.

#### -out

This option outputs the result in a file by just passing the file name between quotes after the option. If not written, the program will output the text to the console.

#### -alg

This option is about specifying the algorithm used in decrypting and encrypting. By entering "shift" without quotes, the program uses the Shift algorithm in other words Ceaser cipher. Another algorithm is Unicode, by entering "unicode". If not specified the program assumes the Shift algorithm.

## Credits

This program is based on the Encryption-Decryption project on [Jet Brains Academy.](https://hyperskill.org/tracks)




