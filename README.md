# CLI-based Chess Game

This is a **Command-Line Interface (CLI)** based chess game implemented in **Java**. The game follows the standard rules of chess, with a text-based interface that allows players to move their pieces, check for checkmates, and more, all within the terminal.

## Features

- **Full Chess Game**: Play a complete game of chess with all the pieces (King, Queen, Rook, Bishop, Knight, and Pawn).
- **Valid Move Enforcement**: The game enforces valid chess moves according to the rules.
- **Check and Checkmate Detection**: The game can detect check and checkmate conditions.
- **Turn-based Gameplay**: Players alternate turns, with the game displaying the board state after each move.
- **Game State Display**: The board is printed to the console, showing the position of all pieces after each turn.
- **Piece Movement Rules**: Includes proper validation for how each piece can move (e.g., Knights move in L-shapes, Rooks move in straight lines, etc.).

## Installation

### Prerequisites

Ensure you have the following installed on your machine:

- **Java Development Kit (JDK)**: You need to have Java installed to run the project. You can download the latest version from [here](https://www.oracle.com/java/technologies/javase-jdk11-downloads.html).
- **Git**: Git is required to clone the repository. If you don't have Git, you can download it from [here](https://git-scm.com/).

### Steps to Install

1. Clone the repository to your local machine:
   ```bash
   git clone https://github.com/vignesh28102006/CLI-based-Chess-Game.git
   
2.Navigate to the project directory:
   cd CLI-based-Chess-Game

3.Compile the Java files:
   javac -d bin src/**/*.java

4.Run the game:
   java -cp bin ChessGame

   
How to Play
Starting the Game:

When you run the program, the game board will be displayed on the terminal with all pieces in their initial positions. White pieces are at the bottom, and Black pieces are at the top.

Moving Pieces:

Players take turns to move their pieces. Each move should be entered as two positions:

The first position represents the piece you want to move (e.g., e2 for a pawn on the second rank).

The second position represents the target square you want to move the piece to (e.g., e4).

Example: To move a pawn from e2 to e4, input: e2 to e4.

The game will validate the move, and if it's legal, the piece will be moved.

Valid Moves:

The game enforces the standard chess movement rules for each piece:

Pawns move forward one square but capture diagonally.

Rooks move horizontally or vertically any number of squares.

Knights move in an L-shape (two squares in one direction and one square perpendicular).

Bishops move diagonally any number of squares.

Queens combine the moves of the rook and bishop.

Kings move one square in any direction.

Invalid moves will be rejected with a message.

Special Rules:

Castling: A special move for the King and Rook when neither has moved, and there are no pieces between them. This move is automatically handled by the game.

Pawn Promotion: When a pawn reaches the last rank, it is automatically promoted to a Queen.

En Passant: This is a special pawn capture rule that can occur under certain conditions, which is also handled automatically by the game.

Check and Checkmate:

The game will notify the player if their move places the opponent’s King in check.

If a player’s King cannot escape check, the game will declare checkmate, and the game ends.

Ending the Game:

The game ends when one player's King is checkmated, or if a draw occurs due to a stalemate or insufficient material.

Example Gameplay
Player 1 (White) - Make your move: e2 to e4
Player 2 (Black) - Make your move: e7 to e5
Player 1 (White) - Make your move: d2 to d4
Player 2 (Black) - Make your move: e5 to e4
Player 1 (White) - Make your move: e4 to e5


CLI-based-Chess-Game/
├── src/                  # Source code for the chess game
│   ├── boardGame/        # Classes related to the board game logic
│   ├── pieces/           # Classes related to the chess pieces
│   ├── views/            # Classes for displaying the game view
│   ├── ChessGame.java    # Main game logic and entry point
├── bin/                  # Compiled class files
├── tests/                # JUnit tests for game functionality
├── .gitignore            # Git ignore file
├── LICENSE               # License for the project
└── README.md             # This README file
