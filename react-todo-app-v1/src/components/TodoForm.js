import React, {useState, useEffect, useRef} from 'react'

function TodoForm(props) {
    const [input, setInput] = useState('');

    const inputRef = useRef(null);

    useEffect(() => {
        inputRef.current.focus()
    })

    const handleChange = e => {
        setInput(e.target.value);
    }

    const handleSubmit = e => {
        e.preventDefault();

        props.onSubmit({
            id: Math.floor(Math.random() * 10000),
            text: input
        });

        setInput('')
    }


  return (
     <div>
        <form className='todo-form' onSubmit={handleSubmit}>
            <input 
                        type="text" 
                        placeholder={(props.edit) ? 'edit your item': 'add your todo'} 
                        value={input} name="text" 
                        className={(props.edit) ? 'todo-input edit' : 'todo-input'}
                        onChange={handleChange}
                        ref={inputRef}
                        />

                    <button className={(props.edit) ? 'todo-button edit' : 'todo-button'}>{(props.edit) ? 'UPDATE': 'Add Todo'}</button>
            

        </form>
     </div>
  )
}

export default TodoForm