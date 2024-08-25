package LogsManager;

public enum LOG {
    OPERATIONS,
    OPERATIONS_IDENTIFIERS;

    @Override
    public String toString() {
        return switch (this){
            case OPERATIONS -> "/home/felipe/IdeaProjects/matrizes_java/src/LogsManager/Logs/Operations.json";
            case OPERATIONS_IDENTIFIERS -> "/home/felipe/IdeaProjects/matrizes_java/src/LogsManager/Logs/OperationsIdentifier.json";
        };
    }
}
