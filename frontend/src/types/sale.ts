import { Seller } from "./seller";

export type Sale = {
    id: number,
    visited: number,
    deals: number,
    amount: number,
    date: string,
    seller: Seller
}

export type SaleWithPagination = {
    content?: Sale[],
    last: boolean,
    totalElements: number,
    totalPages: number,
    size?: number,
    number: number,
    first: boolean,
    numberOfElements?: number,
    empty?: boolean
}

export type SaleTotalPerSeller = {
    sellerName: string,
    total: number
};

export type ConversionRatePerSeller = {
    sellerName: string,
    visited: number,
    deals: number
}