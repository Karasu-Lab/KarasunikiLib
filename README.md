# KarasunikiLib

KarasunikiLib is a lightweight utility library mod for the Fabric Loader, designed to streamline common development tasks for Karasu Lab's mods.

## Features

- **Fluent Text Construction**: Build complex `MutableText` objects with a clean, chainable API using `TextMessageBuilder`.
- **Flexible Configuration Framework**: Reflection-based system to sync class fields with config files and handle change notifications.
- **Structured Client Commands**: Easier registration of client-side commands with built-in subcommand and suggestion support.
- **Advanced Entity Selection**: Enhanced entity filtering, sorting, and limiting through `IEntitySelector` extensions.

## Implemented Functionality

- `TextMessageBuilder`: Simplifying chat messages and UI label construction.
- Reflection Reflectors: Automating the management of Boolean, Number, and String configuration fields.
- `INotifyListener`: Reactive setting updates in real-time.
- `ICommand` Integration: Organized command structures compatible with Minecraft's Brigadier engine.
- Entity Selection Extensions: Sorting results by distance and applying custom predicates.

## How to use

This is a library mod and does not provide direct in-game features for players. To use it in your mod development:

1. Add KarasunikiLib as a dependency in your `build.gradle` file.
2. Utilize the provided APIs under the `com.karasu256.karasunikilib` package.
3. For help with specific interfaces, refer to the source code or integrated Javadocs.

## Contribution

Contributions are welcome! If you have suggestions, bug reports, or would like to submit a pull request, please follow these steps:

1. Fork this repository and create your branch from `master`.
2. Make your changes with clear commit messages.
3. Ensure your code builds and passes any existing checks.
4. Submit a pull request with a description of your changes.

## License

This project is licensed under the Unlicense. See [LICENSE](LICENSE) for details.
