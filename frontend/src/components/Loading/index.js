import ReactLoading from 'react-loading';

export function Loading() {
    return (
        <div className="loading">
            <ReactLoading type='spin' color='#FF5733' height={'20%'} width={'30%'} />
        </div>
    )
}


