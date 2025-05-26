export type ResultadoPaginado<T> = {
    resultado: T,
    temProximaPagina: boolean,
    offsetProximaPagina: number
}